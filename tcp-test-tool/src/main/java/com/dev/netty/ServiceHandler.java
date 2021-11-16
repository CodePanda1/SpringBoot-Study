package com.dev.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by a1100440 on 2018. 5. 2..
 */
public class ServiceHandler extends ChannelInboundHandlerAdapter {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Channel active.
     *
     * @param ctx the ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("【TCP已连接】");
    }

    /**
     * Channel read.
     *
     * @param ctx the ctx
     * @param msg the msg
     * @throws Exception the exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        logger.info("接收到信息为 : {} ", message);
        ctx.channel().writeAndFlush("SUCCESS").addListener(future -> {
            if (future.isSuccess()) {
                logger.info("【信息返回成功】");
            } else {
                logger.info("【信息返回失败】");
            }
        });
    }
}
