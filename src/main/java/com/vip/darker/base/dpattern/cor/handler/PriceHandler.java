package com.vip.darker.base.dpattern.cor.handler;

/**
 * @description: 处理器
 * @auther: WBA
 * @date: 2019/3/7 10:09
 */
public abstract class PriceHandler {

    protected PriceHandler successor;

    /**
     * @description: 责任传递, 下一个人责任人是谁
     * @auther: WBA
     * @date: 2019/3/7 11:37
     * @param: [successor]
     * @return: void
     */
    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * @description: 处理打折申请
     * @auther: WBA
     * @date: 2019/3/7 11:38
     * @param: [discount]
     * @return: void
     */
    public abstract void discount(float discount);
}