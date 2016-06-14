package org.camunda.bpm.dmn.engine.impl.transform;

/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

import org.camunda.bpm.dmn.engine.impl.DmnDecisionImpl;
import org.camunda.bpm.dmn.engine.impl.DmnLogger;
import org.camunda.bpm.dmn.engine.impl.spi.transform.DmnElementTransformContext;
import org.camunda.bpm.dmn.engine.impl.spi.transform.DmnElementTransformHandler;
import org.camunda.bpm.model.dmn.instance.Decision;

public class DmnDecisionTransformHandler implements DmnElementTransformHandler<Decision, DmnDecisionImpl> {

  protected static final DmnTransformLogger LOG = DmnLogger.TRANSFORM_LOGGER;

  public DmnDecisionImpl handleElement(DmnElementTransformContext context, Decision decision) {
    return createFromDecision(context, decision);
  }

  protected DmnDecisionImpl createFromDecision(DmnElementTransformContext context, Decision decision) {
    DmnDecisionImpl decisionEntity = createDmnElement();

    decisionEntity.setKey(decision.getId());
    decisionEntity.setName(decision.getName());
    return decisionEntity;
  }

  protected DmnDecisionImpl createDmnElement() {
    return new DmnDecisionImpl();
  }

}
