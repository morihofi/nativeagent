package de.morihofi.nativeagent;

import io.javalin.Javalin;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SysTray sysTray = new SysTray();

        Javalin app = Javalin.create(javalinConfig -> {
                    javalinConfig.showJavalinBanner = false;
                })
                .get("/", ctx -> ctx.result("Hello World"))
                .get("/notification", ctx -> {
                    String title = ctx.queryParam("title");
                    String content = ctx.queryParam("content");
                    sysTray.displayTray(title, content);
                })
                .get("/calc", ctx -> {
                    Runtime.getRuntime().exec("calc");
                });
        app.start(7070);
    }
}