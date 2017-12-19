package pyxis.uzuki.live.mockupmoduledemo;

import org.jetbrains.annotations.NotNull;

import pyxis.uzuki.live.mockupmodule.Constants;
import pyxis.uzuki.live.mockupmodule.MockupActivity;

public class MainActivity extends MockupActivity {

    @Override
    protected int getNumberOfItems() {
        return 9;
    }

    @Override
    protected int getFilenameLength() {
        return 3;
    }

    @NotNull
    @Override
    protected String getExtension() {
        return Constants.EXTENSION_JPG;
    }

    @NotNull
    @Override
    protected String getPath() {
        return Constants.EMPTY_PATH;
    }
}