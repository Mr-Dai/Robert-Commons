package com.mrdai.commons.function;

import com.mrdai.commons.exception.ExceptionHelper;

@FunctionalInterface
public interface Action {
    Action DO_NOTHING = () -> {};

    void act();

    default Action andThen(Action afterAction) {
        ExceptionHelper.checkArgumentNotNull(afterAction, "afterAction");

        return () -> {
            this.act();
            afterAction.act();
        };
    }
}
