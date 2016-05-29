/**
 *     20.12.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #24
 */

package com.dtalankin;

import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class WatchDir {
    static WatchService watchService;

    static void watchFiles() {
        WatchKey wKey = null;
        for(;;) {
            try {
                wKey = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (WatchEvent<?> event : wKey.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                if (kind == OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> watchEvent = (WatchEvent<Path>)event;
                Path fileName = watchEvent.context();
                if (event.kind().equals(ENTRY_CREATE)) {
                    System.out.println("Created file " + fileName);
                }
                if (event.kind().equals(ENTRY_MODIFY)) {
                    System.out.println("Modified file " + fileName);
                }
                if (event.kind().equals(ENTRY_DELETE)) {
                    System.out.println("Deleted file " + fileName);
                }
                continue;
            }

            boolean valid = wKey.reset();
            if (!valid) {
                break;
            }
        }
    }
}
