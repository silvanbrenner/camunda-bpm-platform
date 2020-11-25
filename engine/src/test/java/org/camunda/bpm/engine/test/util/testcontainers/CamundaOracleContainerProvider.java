/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.util.testcontainers;

import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.OracleContainerProvider;

public class CamundaOracleContainerProvider extends OracleContainerProvider {

  private static final String NAME = "camunda-ci-oracle";

  @Override
  public boolean supports(String databaseType) {
    return NAME.equals(databaseType);
  }

  @Override
  public JdbcDatabaseContainer newInstance(String tag) {
    return new CamundaOracleContainer(TestcontainersHelper.resolveOracleImageName() + ":" + tag);
  }
}