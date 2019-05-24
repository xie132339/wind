package com.wind.comm.util;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive 是的，我还活着 :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null; // 对象第一次拯救自己
        System.gc(); //调用垃圾收集器
        // 因为Finalize 方法优先级很低，所有暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead 不，我死了 :(");
        }
        
        //下面这段代码与上面完全相同，但是这次自救却失败了。
        SAVE_HOOK = null; // 对象第一次拯救自己
        System.gc();
        // 因为Finalize 方法优先级很低，所有暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead 不，我死了 :(");
        }
    }
}
