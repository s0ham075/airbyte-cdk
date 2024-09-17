/*
 * Copyright (c) 2024 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.cdk.mock_integration_test

import io.airbyte.cdk.command.DestinationConfiguration
import io.airbyte.cdk.command.DestinationConfigurationFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

data class MockDestinationConfiguration(
    override val recordBatchSizeBytes: Long = 1024 * 1024,
    override val firstStageTmpFilePrefix: String =
        DestinationConfiguration.DEFAULT_FIRST_STAGE_TMP_FILE_PREFIX,
    override val maxMessageQueueMemoryUsageRatio: Double =
        DestinationConfiguration.DEFAULT_MAX_MESSAGE_QUEUE_MEMORY_USAGE_RATIO,
    override val estimatedRecordMemoryOverheadRatio: Double =
        DestinationConfiguration.DEFAULT_ESTIMATED_RECORD_MEMORY_OVERHEAD_RATIO,
) : DestinationConfiguration

@Singleton
class MockDestinationConfigurationFactory :
    DestinationConfigurationFactory<
        MockDestinationConfigurationJsonObject, MockDestinationConfiguration> {

    override fun makeWithoutExceptionHandling(
        pojo: MockDestinationConfigurationJsonObject
    ): MockDestinationConfiguration {
        return MockDestinationConfiguration(pojo.testDestination)
    }
}

@Factory
class MockDestinationConfigurationProvider(private val config: DestinationConfiguration) {
    @Singleton
    fun get(): MockDestinationConfiguration {
        return config as MockDestinationConfiguration
    }
}
