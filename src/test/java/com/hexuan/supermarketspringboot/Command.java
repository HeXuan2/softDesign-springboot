package com.hexuan.supermarketspringboot;

/**
 * @Author hexuan
 * @Date 2024/1/8 14:22
 * @PackageName:com.hexuan.supermarketspringboot
 * @ClassName: Command
 * @Description: TODO
 */
public interface Command {
    void execute();
    void undo();
    void redo();
}
