package com.example.oc_lab_benchmark.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Platform;

public class FileLogger implements ILogger {
    BufferedWriter out = null;

    public FileLogger(String s) {
        try {
            out = new BufferedWriter(new FileWriter(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(long l) {
        Platform.runLater(() -> {
            try {
                out.write(l + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void write(String s) {
        Platform.runLater(() -> {
            try {
                out.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void write(Object... objects) {
        Platform.runLater(() -> {
            String s = "";
            for(Object o: objects) {
                s = s + o.toString();
            }

            try {
                out.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void close() {
        Platform.runLater(() -> {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void writeTime(long value, TimeUnit unit) {
        Platform.runLater(() -> {
            try {
                switch(unit) {
                    case Nano:
                        out.write(value + "Nano");
                        break;
                    case Micro:
                        out.write(value / Math.pow(10, 3) + "Micro");
                        break;
                    case Milli:
                        out.write(value / Math.pow(10, 6) + "Milli");
                        break;
                    case Sec:
                        out.write(value / Math.pow(10, 9) + "Sec");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void writeTime(String string, long value, TimeUnit unit) {
        Platform.runLater(() -> {
            try {
                switch(unit) {
                    case Nano:
                        out.write(string + " " + value + "Nano");
                        break;
                    case Micro:
                        out.write(string + " " + value / Math.pow(10, 3) + "Micro");
                        break;
                    case Milli:
                        out.write(string + " " + value / Math.pow(10, 6) + "Milli");
                        break;
                    case Sec:
                        out.write(string + " " + value / Math.pow(10, 9) + "Sec");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
