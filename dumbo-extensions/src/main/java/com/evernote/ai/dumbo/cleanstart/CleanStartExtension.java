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
package com.evernote.ai.dumbo.cleanstart;

import com.evernote.ai.dumbo.AppHTTPServer;
import com.evernote.ai.dumbo.Extension;

/**
 * Hide the page BODY until the app is ready.
 */
public final class CleanStartExtension extends Extension {
  @Override
  public void init(final AppHTTPServer server) {
    server.registerContext("/_app_cleanstart", CleanStartExtension.class
        .getResource("webapp/"));
  }

  @Override
  protected void initResources() {
    registerCSS("/_app_cleanstart/css/cleanstart.css");
    registerAsyncJavaScript("/_app_cleanstart/js/cleanstart.js");
  }
}
