package com.cactt4ck.sui.utils;

import java.io.*;
import java.util.Properties;

public class AppConfig extends Properties {

    private final String directory, config, defaultConfig;
    private File configFolder, configFile;

    public AppConfig() {
        this.directory = System.getenv("APPDATA") + File.separator + "ResourcePack Editor" + File.separator;
        this.config = "config.properties";
        this.defaultConfig = "/assets/config/config.properties";

        this.init();
        this.loadConfig();
    }

    private void init() {
        this.configFolder = new File(this.directory);
        this.configFile = new File(this.directory + this.config);
        if (!configFolder.exists()) {
            if (!configFolder.mkdirs())
                System.out.println("Impossible de créer le dossier de configuration");
        }

        if (!configFile.exists()) {
            try (InputStream is = AppConfig.class.getResourceAsStream(defaultConfig);
                 OutputStream os = new FileOutputStream(configFile)) {

                if (is == null) {
                    throw new IOException("Le fichier de configuration par défaut n'a pas été trouvé");
                }

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1)
                    os.write(buffer, 0, bytesRead);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadConfig() {
        try (InputStream is = new FileInputStream(this.directory + this.config)) {
            this.load(is);
            System.out.println(this.getProperty("theme"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveConfig() {
        try (OutputStream output = new FileOutputStream(this.configFile)) {
            this.store(output, null);
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}
