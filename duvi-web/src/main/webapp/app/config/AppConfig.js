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
// Generated by CoffeeScript 1.4.0
/**
* Application configuration class, including endpoint lookup and runtime setting for mock vs. live data access.
* Inject into stores or custom proxy objects to resolve endpoints for loading data.
*/

Ext.define("Duvi.config.AppConfig", {
  statics: {
    MOCK_DATA_ENV: "MOCK_DATA_ENV",
    PRODUCTION_ENV: "PRODUCTION_ENV"
  },
  config: {
    environment: null,
    MOCK_DATA_ENV: {
      endpoints: {
        sampleEndpointName: {
          url: "mockdata/generic-success.json"
        }
      },
      defaults: {
        urlPrefix: "data/",
        urlSuffix: ".json",
        dataRoot: ""
      }
    },
    PRODUCTION_ENV: {
      endpoints: {
        sampleEndpointName: {
          url: "/liveUrlForSampleData"
        }
      },
      defaults: {
        urlPrefix: "/",
        urlSuffix: ".json",
        dataRoot: ""
      }
    }
  },
  /**
  * Configures the application, particularly the endpoints used for server requests.
  * @param {Object} cfg A configuration object, usually pulled from a static property in an application-specific configuration class.
  * @param {String} environment Determines whether live server calls or mock JSON data files should be used. Set to MOCK_DATA_ENV or PRODUCTION_ENV. If no environment is specified, defaults to PRODUCTION_ENV.
  */

  constructor: function(cfg) {
    if ((cfg != null ? cfg.environment : void 0) && (Duvi.config.AppConfig[cfg.environment] != null)) {
      return this.setEnvironment(Duvi.config.AppConfig[cfg.environment]);
    } else {
      return this.setEnvironment(Duvi.config.AppConfig.PRODUCTION_ENV);
    }
  },
  /**
  * Given an endpoint name, returns the URL and root JSON data element for that endpoint. If no endpoint can be found, attempt to use the default url prefix and suffix.
  * @param {String} Endpoint name
  * @return {Object} Object with keys [url] and [root]
  */

  getEndpoint: function(endpointName) {
    var defaults, endpoints, environmentConfig, result, _ref, _ref1;
    environmentConfig = this[this.getEnvironment()];
    endpoints = environmentConfig.endpoints;
    defaults = environmentConfig.defaults;
    if (endpoints != null ? endpoints[endpointName] : void 0) {
      return result = {
        url: endpoints[endpointName].url,
        root: (_ref = (_ref1 = endpoints[endpointName]) != null ? _ref1.root : void 0) != null ? _ref : defaults.dataRoot
      };
    } else {
      return result = {
        url: defaults.urlPrefix + endpointName + defaults.urlSuffix,
        root: defaults.dataRoot
      };
    }
  }
});
