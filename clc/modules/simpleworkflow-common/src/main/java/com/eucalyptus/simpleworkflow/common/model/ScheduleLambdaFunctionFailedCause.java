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

/**
 * Schedule Lambda Function Failed Cause
 */
public enum ScheduleLambdaFunctionFailedCause {
    
    ID_ALREADY_IN_USE("ID_ALREADY_IN_USE"),
    OPEN_LAMBDA_FUNCTIONS_LIMIT_EXCEEDED("OPEN_LAMBDA_FUNCTIONS_LIMIT_EXCEEDED"),
    LAMBDA_FUNCTION_CREATION_RATE_EXCEEDED("LAMBDA_FUNCTION_CREATION_RATE_EXCEEDED"),
    LAMBDA_SERVICE_NOT_AVAILABLE_IN_REGION("LAMBDA_SERVICE_NOT_AVAILABLE_IN_REGION");

    private String value;

    private ScheduleLambdaFunctionFailedCause(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value
     *            real value
     * @return ScheduleLambdaFunctionFailedCause corresponding to the value
     */
    public static ScheduleLambdaFunctionFailedCause fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        
        } else if ("ID_ALREADY_IN_USE".equals(value)) {
            return ScheduleLambdaFunctionFailedCause.ID_ALREADY_IN_USE;
        } else if ("OPEN_LAMBDA_FUNCTIONS_LIMIT_EXCEEDED".equals(value)) {
            return ScheduleLambdaFunctionFailedCause.OPEN_LAMBDA_FUNCTIONS_LIMIT_EXCEEDED;
        } else if ("LAMBDA_FUNCTION_CREATION_RATE_EXCEEDED".equals(value)) {
            return ScheduleLambdaFunctionFailedCause.LAMBDA_FUNCTION_CREATION_RATE_EXCEEDED;
        } else if ("LAMBDA_SERVICE_NOT_AVAILABLE_IN_REGION".equals(value)) {
            return ScheduleLambdaFunctionFailedCause.LAMBDA_SERVICE_NOT_AVAILABLE_IN_REGION;
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        }
    }
}
    