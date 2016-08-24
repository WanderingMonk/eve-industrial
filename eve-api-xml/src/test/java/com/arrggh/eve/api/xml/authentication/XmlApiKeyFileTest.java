package com.arrggh.eve.api.xml.authentication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlApiKeyFileTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testApiKeyFile() throws IOException {
        XmlApiKeyFile keyFile = new XmlApiKeyFile(folder.newFile("keyfile.tmp"));
        assertEquals(0, keyFile.loadKeys().size());

        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

        List<XmlApiKey> keys = Arrays.asList(key);
        assertEquals(1, keys.size());
        keyFile.saveKeys(keys);

        List<XmlApiKey> loadedKeys = keyFile.loadKeys();
        assertEquals(1, loadedKeys.size());
        XmlApiKey loadedKey = loadedKeys.get(0);

        assertEquals(key, loadedKey);
    }

    @Test
    public void testApiKeyFileHandlesWriteErrors() throws IOException {
        XmlApiKeyFile keyFile = new XmlApiKeyFile(folder.newFile("keyfile.tmp")){
            @Override
            protected void writeFile(List<XmlApiKey> keys) throws IOException {
                throw new IOException("Test Error");
            }
        };
        assertEquals(0, keyFile.loadKeys().size());

        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

        List<XmlApiKey> keys = Arrays.asList(key);
        keyFile.saveKeys(keys);

        List<XmlApiKey> loadedKeys = keyFile.loadKeys();
        assertEquals(0, loadedKeys.size());
    }

    @Test
    public void testApiKeyFileReadErrors() throws IOException {
        XmlApiKeyFile keyFile = new XmlApiKeyFile(folder.newFile("keyfile.tmp")) {
            @Override
            protected XmlApiKey[] readFile() throws IOException {
                throw new IOException("Test Error");
            }
        };
        assertEquals(0, keyFile.loadKeys().size());

        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

        List<XmlApiKey> keys = Arrays.asList(key);
        keyFile.saveKeys(keys);

        List<XmlApiKey> loadedKeys = keyFile.loadKeys();
        assertEquals(0, loadedKeys.size());
    }
}