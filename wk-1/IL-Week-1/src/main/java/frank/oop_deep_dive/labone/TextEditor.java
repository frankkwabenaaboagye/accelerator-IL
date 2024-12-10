package frank.oop_deep_dive.labone;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TextEditor {

    private final TextFormatter textFormatter;

    public void publishText(String text){
        textFormatter.format(text);
    }

}
