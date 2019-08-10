package com.what2drive.service_common.utils.text;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple text file parser
 *
 * It will read a text file line by line and save them in a list
 *
 * It will also save this text file in a string
 */
public class TextFileParser {
    private File file;
    private List<String> lines;
    private String text;

    /**
     * Constructor
     * @param file file to parse
     */
    public TextFileParser(File file) {
        this.file = file;
        this.lines = new LinkedList<>();
        this.text = "";
    }

    public static TextFileParser buildForFile(String absolutePathToFile) {
        return new TextFileParser(new File(absolutePathToFile));
    }

    public static TextFileParser buildForFileInResourcesFolder(String pathToFileInResourcesFolder) {
        ClassLoader classLoader = TextFileParser.class.getClassLoader();
        URL resource = classLoader.getResource(pathToFileInResourcesFolder);
        String absolutePath = resource.getFile();
        return buildForFile(absolutePath);
    }

    /**
     * Internal reading procedure
     * @throws IOException
     */
    private void readInternal() throws TextFileParserException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			// Read the lines
			String line = bufferedReader.readLine();
			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
			}

			// Join lines in one text
			for (String tempLine : lines)
				text += tempLine + "\n";
		} catch (IOException e) {
			throw new TextFileParserException(e);
		}
    }

    /**
     * External control for reading
     */
    public void read() {
    	this.readInternal();
    }

    /**
     * Getter
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * Getter
     * @return list of lines
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * Getter
     * @return whole text
     */
    public String getText() {
        return text;
    }
}