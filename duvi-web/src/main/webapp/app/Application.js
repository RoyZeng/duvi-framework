/*
 * Copyright (C) 2014 Jorge S. (duvi-framework@jsan.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
* DeftJS Application class for the Duvi application.
*/

Ext.define("Duvi.Application", {
  extend: "Deft.mvc.Application",
  requires: ["Duvi.config.AppConfig", "Duvi.view.Viewport"],
  /**
  * init() runs when Ext.onReady() is called.
  */

  init: function() {
    this.beforeInit();
    Deft.Injector.configure(this.buildInjectorConfiguration());
    return this.afterInit();
  },
  /**
  * @protected
  * Returns the configuration object to pass to Deft.Injector.configure(). Override in subclasses to alter the Injector configuration before returning the config object.
  * @return {Object} The Injector configuration object.
  */

  buildInjectorConfiguration: function() {
    var config;
    config = {
      appConfig: {
        className: "Duvi.config.AppConfig",
        parameters: [
          {
            environment: Duvi.config.AppConfig.MOCK_DATA_ENV
          }
        ]
      }
    };
    return config;
  },
  /**
  * @protected
  * Runs at the start of the init() method. Override in subclasses if needed.
  */

  beforeInit: function() {},
  /**
  * @protected
  * Runs at the end of the init() method. Useful to create initial Viewport, start Jasmine tests, etc.
  */

  afterInit: function() {
    Ext.tip.QuickTipManager.init();
    return Ext.create("Duvi.view.Viewport");
  }
});
