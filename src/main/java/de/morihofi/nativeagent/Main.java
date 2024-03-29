package de.morihofi.nativeagent;

import io.javalin.Javalin;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SysTray sysTray = new SysTray();

        Javalin app = Javalin.create(javalinConfig -> {
                    javalinConfig.showJavalinBanner = false;
                })
                .before(ctx -> {
                    ctx.header("Access-Control-Allow-Origin","*");
                    ctx.header("Access-Control-Allow-Methods","*");
                    ctx.header("Access-Control-Allow-Headers","*");
                    ctx.header("Access-Control-Max-Age", "3600");
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
        app.start("127.0.0.1", 7070);
    }
}