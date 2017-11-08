/*************************************************************************
 * Copyright 2014 Ent. Services Development Corporation LP
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
 *
 * This file may incorporate work covered under the following copyright
 * and permission notice:
 *
 *   Copyright 2010-2015 Amazon.com, Inc. or its affiliates.
 *   All Rights Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License").
 *   You may not use this file except in compliance with the License.
 *   A copy of the License is located at
 *
 *     http://aws.amazon.com/apache2.0
 *
 *   or in the "license" file accompanying this file. This file is
 *   distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
 *   ANY KIND, either express or implied. See the License for the specific
 *   language governing permissions and limitations under the License.
 ************************************************************************/
package com.eucalyptus.simpleworkflow.common.model;

import java.io.Serializable;
import javax.annotation.Nonnull;
import com.eucalyptus.auth.policy.annotation.PolicyAction;

/**
 * Container for the parameters to the {@link com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow#recordActivityTaskHeartbeat(RecordActivityTaskHeartbeatRequest) RecordActivityTaskHeartbeat operation}.
 * <p>
 * Used by activity workers to report to the service that the
 * ActivityTask represented by the specified <code>taskToken</code> is
 * still making progress. The worker can also (optionally) specify
 * details of the progress, for example percent complete, using the
 * <code>details</code> parameter. This action can also be used by the
 * worker as a mechanism to check if cancellation is being requested for
 * the activity task. If a cancellation is being attempted for the
 * specified task, then the boolean <code>cancelRequested</code> flag
 * returned by the service is set to <code>true</code> .
 * </p>
 * <p>
 * This action resets the <code>taskHeartbeatTimeout</code> clock. The
 * <code>taskHeartbeatTimeout</code> is specified in
 * RegisterActivityType.
 * </p>
 * <p>
 * This action does not in itself create an event in the workflow
 * execution history. However, if the task times out, the workflow
 * execution history will contain a <code>ActivityTaskTimedOut</code>
 * event that contains the information from the last heartbeat generated
 * by the activity worker.
 * </p>
 * <p>
 * <b>NOTE:</b>The taskStartToCloseTimeout of an activity type is the
 * maximum duration of an activity task, regardless of the number of
 * RecordActivityTaskHeartbeat requests received. The
 * taskStartToCloseTimeout is also specified in RegisterActivityType.
 * </p>
 * <p>
 * <b>NOTE:</b>This operation is only useful for long-lived activities to
 * report liveliness of the task and to determine if a cancellation is
 * being attempted.
 * </p>
 * <p>
 * <b>IMPORTANT:</b>If the cancelRequested flag returns true, a
 * cancellation is being attempted. If the worker can cancel the
 * activity, it should respond with RespondActivityTaskCanceled.
 * Otherwise, it should ignore the cancellation request.
 * </p>
 * <p>
 * <b>Access Control</b>
 * </p>
 * <p>
 * You can use IAM policies to control this action's access to Amazon SWF
 * resources as follows:
 * </p>
 * 
 * <ul>
 * <li>Use a <code>Resource</code> element with the domain name to limit
 * the action to only specified domains.</li>
 * <li>Use an <code>Action</code> element to allow or deny permission to
 * call this action.</li>
 * <li>You cannot use an IAM policy to constrain this action's
 * parameters.</li>
 * 
 * </ul>
 * <p>
 * If the caller does not have sufficient permissions to invoke the
 * action, or the parameter values fall outside the specified
 * constraints, the action fails. The associated event attribute's
 * <b>cause</b> parameter will be set to OPERATION_NOT_PERMITTED. For
 * details and example IAM policies, see
 * <a href="http://docs.aws.amazon.com/amazonswf/latest/developerguide/swf-dev-iam.html"> Using IAM to Manage Access to Amazon SWF Workflows </a>
 * .
 * </p>
 *
 * @see com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow#recordActivityTaskHeartbeat(RecordActivityTaskHeartbeatRequest)
 */
@PolicyAction( vendor = "swf", action = "recordactivitytaskheartbeat" )
public class RecordActivityTaskHeartbeatRequest extends SimpleWorkflowMessage implements Serializable {

    /**
     * The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     * <code>taskToken</code> is generated by the service and should be
     * treated as an opaque value. If the task is passed to another process,
     * its <code>taskToken</code> must also be passed. This enables it to
     * provide its progress and respond with results. </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     */
    @Nonnull
    @FieldRegex( FieldRegexValue.STRING_1024 )
    private String taskToken;

    /**
     * If specified, contains details about the progress of the task.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 2048<br/>
     */
    @FieldRegex( FieldRegexValue.OPT_STRING_2048 )
    private String details;

    /**
     * The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     * <code>taskToken</code> is generated by the service and should be
     * treated as an opaque value. If the task is passed to another process,
     * its <code>taskToken</code> must also be passed. This enables it to
     * provide its progress and respond with results. </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @return The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     *         <code>taskToken</code> is generated by the service and should be
     *         treated as an opaque value. If the task is passed to another process,
     *         its <code>taskToken</code> must also be passed. This enables it to
     *         provide its progress and respond with results. </important>
     */
    public String getTaskToken() {
        return taskToken;
    }
    
    /**
     * The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     * <code>taskToken</code> is generated by the service and should be
     * treated as an opaque value. If the task is passed to another process,
     * its <code>taskToken</code> must also be passed. This enables it to
     * provide its progress and respond with results. </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @param taskToken The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     *         <code>taskToken</code> is generated by the service and should be
     *         treated as an opaque value. If the task is passed to another process,
     *         its <code>taskToken</code> must also be passed. This enables it to
     *         provide its progress and respond with results. </important>
     */
    public void setTaskToken(String taskToken) {
        this.taskToken = taskToken;
    }
    
    /**
     * The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     * <code>taskToken</code> is generated by the service and should be
     * treated as an opaque value. If the task is passed to another process,
     * its <code>taskToken</code> must also be passed. This enables it to
     * provide its progress and respond with results. </important>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1024<br/>
     *
     * @param taskToken The <code>taskToken</code> of the <a>ActivityTask</a>. <important>
     *         <code>taskToken</code> is generated by the service and should be
     *         treated as an opaque value. If the task is passed to another process,
     *         its <code>taskToken</code> must also be passed. This enables it to
     *         provide its progress and respond with results. </important>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RecordActivityTaskHeartbeatRequest withTaskToken(String taskToken) {
        this.taskToken = taskToken;
        return this;
    }

    /**
     * If specified, contains details about the progress of the task.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 2048<br/>
     *
     * @return If specified, contains details about the progress of the task.
     */
    public String getDetails() {
        return details;
    }
    
    /**
     * If specified, contains details about the progress of the task.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 2048<br/>
     *
     * @param details If specified, contains details about the progress of the task.
     */
    public void setDetails(String details) {
        this.details = details;
    }
    
    /**
     * If specified, contains details about the progress of the task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 2048<br/>
     *
     * @param details If specified, contains details about the progress of the task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RecordActivityTaskHeartbeatRequest withDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTaskToken() != null) sb.append("TaskToken: " + getTaskToken() + ",");
        if (getDetails() != null) sb.append("Details: " + getDetails() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getTaskToken() == null) ? 0 : getTaskToken().hashCode()); 
        hashCode = prime * hashCode + ((getDetails() == null) ? 0 : getDetails().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof RecordActivityTaskHeartbeatRequest == false) return false;
        RecordActivityTaskHeartbeatRequest other = (RecordActivityTaskHeartbeatRequest)obj;
        
        if (other.getTaskToken() == null ^ this.getTaskToken() == null) return false;
        if (other.getTaskToken() != null && other.getTaskToken().equals(this.getTaskToken()) == false) return false; 
        if (other.getDetails() == null ^ this.getDetails() == null) return false;
        if (other.getDetails() != null && other.getDetails().equals(this.getDetails()) == false) return false; 
        return true;
    }
}
    