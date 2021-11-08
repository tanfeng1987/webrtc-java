/*
 * Copyright 2019 Alex Andres
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package dev.onvoid.webrtc.media.audio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import dev.onvoid.webrtc.TestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AudioProcessingTests extends TestBase {

	private AudioProcessing audioProcessing;


	@BeforeEach
	void init() {
		audioProcessing = new AudioProcessing();
	}

	@AfterEach
	void dispose() {
		audioProcessing.dispose();
	}

	@Test
	void applyConfig() {
		AudioProcessingConfig config = new AudioProcessingConfig();
		config.echoCancellerEnabled = true;
		config.residualEchoDetectorEnabled = true;
		config.gainControlEnabled = true;
		config.highPassFilterEnabled = true;
		config.noiseSuppressionEnabled = true;
		config.transientSuppressionEnabled = true;
		config.levelEstimationEnabled = true;
		config.voiceDetectionEnabled = true;

		audioProcessing.applyConfig(config);
	}

	@Test
	void getStats() {
		assertNotNull(audioProcessing.getStatistics());
	}

}
