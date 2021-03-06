package com.framgia.wsm.utils.navigator;

import android.support.annotation.IntDef;

/**
 * Created by framgia on 05/05/2017.
 */

@IntDef({
        NavigateAnim.RIGHT_LEFT, NavigateAnim.BOTTOM_UP, NavigateAnim.FADED, NavigateAnim.NONE,
        NavigateAnim.LEFT_RIGHT
})
public @interface NavigateAnim {
    int NONE = 0x00;
    int RIGHT_LEFT = 0x01;
    int BOTTOM_UP = 0x02;
    int FADED = 0x03;
    int LEFT_RIGHT = 0x04;
}
