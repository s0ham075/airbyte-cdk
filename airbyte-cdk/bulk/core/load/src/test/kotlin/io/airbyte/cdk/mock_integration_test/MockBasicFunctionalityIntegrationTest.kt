package io.airbyte.cdk.mock_integration_test

import io.airbyte.cdk.command.ConfigurationJsonObjectBase
import io.airbyte.cdk.test.util.DestinationDataDumper
import io.airbyte.cdk.test.util.NoopDestinationCleaner
import io.airbyte.cdk.test.util.NoopExpectedRecordMapper
import io.airbyte.cdk.test.util.NoopNameMapper
import io.airbyte.cdk.test.write.BasicFunctionalityIntegrationTest

class MockBasicFunctionalityIntegrationTest: BasicFunctionalityIntegrationTest(
    object: ConfigurationJsonObjectBase() {},
    DestinationDataDumper { streamName, streamNamespace ->
        MockDestinationBackend.readFile(MockStreamLoader.getFilename(streamNamespace, streamName))
    },
    NoopDestinationCleaner,
    NoopExpectedRecordMapper,
    NoopNameMapper
) {
}
