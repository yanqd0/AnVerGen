/*
 * Copyright 2016 Yan QiDong
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

package org.no_creativity.anvergen

import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

/**
 * @author yanqd0
 */
class VerTest {
    @Test
    public void testGenerateVersionCode() throws Exception {
        Process process = "git rev-list --count HEAD".execute()
        process.waitFor()
        int commits = process.getText().toInteger()

        assertEquals(commits, Ver.generateVersionCode())
        assertEquals(commits, Ver.generateVersionCode())
    }

    @Test
    public void testGenerateVersionName() throws Exception {
        String name = Ver.generateVersionName()
        assertTrue(name.startsWith(Git.getLatestTag()))
        assertTrue(name.contains(new Date().format("yyMMdd")))
        assertTrue(name.endsWith(Git.getShortSha1()))
    }
}
