package io.airbyte.cdk.mock_integration_test

import io.airbyte.cdk.check.DestinationCheckOperation
import javax.inject.Singleton

@Singleton
class MockDestinationCheck: DestinationCheckOperation<Any> {
    override fun check(config: Any) {}
}
