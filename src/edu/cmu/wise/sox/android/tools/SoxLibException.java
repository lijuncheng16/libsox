/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package edu.cmu.wise.sox.android.tools;

/**
 * Base exception class which is thrown when there is a problem in the SOX
 * library.
 *
 * @author css@google.com (Charles Spirakis)
 */
public class SoxLibException extends RuntimeException {
  /**
   * Default serialization version
   */
  private static final long serialVersionUID = 1L;

  public SoxLibException() {
  }

  public SoxLibException(String msg) {
    super(msg);
  }

  public SoxLibException(Throwable cause) {
    super(cause);
  }

  public SoxLibException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
