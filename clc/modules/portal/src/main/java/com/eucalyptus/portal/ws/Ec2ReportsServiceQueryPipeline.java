/*************************************************************************
 * Copyright 2016 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.portal.ws;

import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.portal.common.Ec2Reports;
import com.eucalyptus.portal.config.Ec2ReportsServiceConfiguration;
import com.eucalyptus.ws.server.QueryPipeline;
import com.eucalyptus.ws.util.HmacUtils;
import org.jboss.netty.channel.ChannelPipeline;

import java.util.EnumSet;

@SuppressWarnings( "unused" )
@ComponentPart( Ec2Reports.class )
public class Ec2ReportsServiceQueryPipeline extends QueryPipeline {
  public Ec2ReportsServiceQueryPipeline() {
    super(
            "ec2reportsservice-query",
            Ec2ReportsServiceConfiguration.SERVICE_PATH,
            EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ),
            EnumSet.of( HmacUtils.SignatureVersion.SignatureV4 ) ) ;
  }

  @Override
  public ChannelPipeline addHandlers(final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "ec2reportsservice-query-binding", new Ec2ReportsServiceQueryBinding( ) );
    return pipeline;
  }
}
