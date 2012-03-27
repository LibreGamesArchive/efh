package ru.znay.znay.he.gfx.gui;

/**
 * Created by IntelliJ IDEA.
 * User: ASTarasov
 * Date: 27.03.12
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class TypedTextPanel extends TextPanel {
    private int position;
    private int period;
    private long time;
    private int timeLife;

    public TypedTextPanel(String mes, int posX, int posY, int colors, int period) {
        super(mes, posX, posY, colors);
        this.position = 1;
        this.period = period;
        this.time = System.currentTimeMillis();
        this.timeLife = 100;
        setText(originalMessage.substring(0, this.position));
    }

    @Override
    public void tick() {
        if (System.currentTimeMillis() - this.time > this.period) {

            this.position = Math.min(originalMessage.length(), this.position + 1);

            setText(originalMessage.substring(0, this.position));

            this.time = System.currentTimeMillis();
        }

        if (this.position == originalMessage.length()) {
            timeLife--;
        }
        if (timeLife <= 0) closed = true;
    }
}