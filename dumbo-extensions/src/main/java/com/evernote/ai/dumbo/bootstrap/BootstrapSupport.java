/**
 * Copyright 2014,2015 Evernote Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.evernote.ai.dumbo.bootstrap;

import java.util.Scanner;

import javax.servlet.http.HttpSession;

import com.evernote.ai.dumbo.AppHTTPServer;
import com.evernote.ai.dumbo.Extension;

/**
 * Helper class to add Bootstrap.js support to the demo server.
 * 
 * @see dumbo-helloworld
 */
public final class BootstrapSupport extends Extension {
  private static final String HTML_NO_LONGER_CURRENT;
  private final boolean extras;

  static {
    HTML_NO_LONGER_CURRENT =
        new Scanner(BootstrapSupport.class
            .getResourceAsStream("include/noLongerCurrent.html"), "UTF-8").useDelimiter(
            "\\Z").next();
  }

  /**
   * Initializes bootstrap support with some custom additions.
   */
  public BootstrapSupport() {
    this(true);
  }

  /**
   * Initializes bootstrap support.
   * 
   * @param extras If {@code true}, custom additions will be enabled. If {@code false},
   *          only the library is provided.
   */
  public BootstrapSupport(boolean extras) {
    this.extras = extras;
  }

  @Override
  public void init(final AppHTTPServer server) {
    server.registerContext("/_app_bootstrap", BootstrapSupport.class
        .getResource("webapp/"));
  }

  @Override
  protected void initResources() {
    registerCSS("/_app_bootstrap/css/bootstrap.min.css");
    registerCSS("/_app_bootstrap/css/bootstrap-extras.css");
    registerJavaScript("/_app_bootstrap/js/bootstrap.min.js");
    registerJavaScript("/_app_bootstrap/js/bootstrap-extras.js");
  }

  @Override
  public String htmlBodyTop(final HttpSession context) {
    if (extras) {
      return HTML_NO_LONGER_CURRENT;
    } else {
      return "";
    }
  }
}
