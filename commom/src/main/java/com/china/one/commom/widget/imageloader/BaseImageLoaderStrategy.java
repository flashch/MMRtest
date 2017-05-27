package com.china.one.commom.widget.imageloader;

import android.content.Context;

public interface BaseImageLoaderStrategy<T extends ImageConfig> {
    void loadImage(Context ctx, T config);
    void clear(Context ctx, T config);
}
