package kata6.view;

import kata6.model.Block;

/**
 *
 * @author alvaroafonsolopez
 */
public interface BlockDisplay extends Block.Observer {
    void display(Block block);
}
