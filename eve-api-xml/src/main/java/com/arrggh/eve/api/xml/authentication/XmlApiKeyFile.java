package com.arrggh.eve.api.xml.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple class that stores a set of XmlApiKeys in a file.
 *
 * The XmlApiKeys are stored in a JSON encoded file, specified in the constructor. For simplicities sake the keys are
 * loaded and saved in a single operation providing a list of them.
 */
public class XmlApiKeyFile {
    private ObjectMapper mapper = new ObjectMapper();
    private File keyfile;

    public XmlApiKeyFile(File keyfile) {
        this.keyfile = keyfile;
    }

    public List<XmlApiKey> loadKeys() {
        try {
            XmlApiKey[] keys = readFile();
            return Arrays.asList(keys);
        } catch (IOException e) {
            System.err.println("Cannot read key file: " + e);
            return new LinkedList<>();
        }
    }

    public void saveKeys(List<XmlApiKey> keys) {
        try {
            writeFile(keys);
        } catch (IOException e) {
            System.err.println("Cannot write file: " + e);
        }
    }

    protected XmlApiKey[] readFile() throws IOException {
        return mapper.readValue(keyfile, XmlApiKey[].class);
    }

    protected void writeFile(List<XmlApiKey> keys) throws IOException {
        mapper.writeValue(keyfile, keys);
    }
}
