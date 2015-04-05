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
package com.evernote.ai.helloworld;

import java.io.IOException;

import com.evernote.ai.dumbo.AppHTTPServer;
import com.evernote.ai.dumbo.RPCRegistry;
import com.evernote.ai.dumbo.ServerApp;
import com.evernote.ai.dumbo.ext.AppDefaultsSupport;

/**
 * A simple "Hello world" demo app, using {@link AppHTTPServer} and JSON-RPC.
 */
public class HelloWorldApp extends ServerApp {
  public static void main(String[] args) throws IOException {
    final HelloWorldApp app = new HelloWorldApp();
    new AppHTTPServer(app).start();
  }

  @Override
  protected void initRPC(final RPCRegistry registry) {
    registry.registerRPCService(DemoService.class, new DemoServiceImpl());
  }

  @Override
  protected void initExtensions() {
    registerExtension(new AppDefaultsSupport());
  }
}
