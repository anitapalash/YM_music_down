package org.kurdev.YM_music_down.util;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileNotFoundException;

public class JavaScriptInterpreter {

    public static void getPlayListWithYandexApi(String userId, String playlistId) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
//            if (!(engine instanceof Invocable)) {
//                System.out.println("Invoking methods is not supported.");
//                return;
//            }
            Invocable inv = (Invocable) engine;

            String scriptPath = String.valueOf(JavaScriptInterpreter.class.getResource("/webapp/getPlaylistScript.js"));
            if (scriptPath != null) {
                engine.eval("load('" + scriptPath + "')");
                Object scriptor = engine.get("scriptor");
                Object result = inv.invokeMethod(scriptor, "getPlaylist", userId, playlistId);

                System.out.println(result);
            } else throw new FileNotFoundException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
