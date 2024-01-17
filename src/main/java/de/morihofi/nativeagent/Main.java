package de.morihofi.nativeagent;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(javalinConfig -> {
                    javalinConfig.showJavalinBanner = false;
                })
                .get("/", ctx -> ctx.result("Hello World"));
        app.start(7070);
    }
}