package dictionary;

public class GADDAGNode {
    private static int idCounter = 0;
    private final int id;
    // number of children is max 27 ( 26 chars arcs, 1 delimiter arc)
    GADDAGNode [] children = new GADDAGNode[27];
    // first 27 bits will be used to form arcs between parent and children
    int transitionArcs = 0;
    int terminalArcs = 0;

    GADDAGNode() {
        ++idCounter;
        id = idCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    //sets the arc connecting child node with parent node
    public GADDAGNode setTransitionArc(char transitionChar, GADDAGNode child) {
        GADDAGNode currentArcEndpoint = this.getChildNode(transitionChar);
        if(currentArcEndpoint == null) {
            // get number of positions needed to shift 1 to make bitFlag
            int positions = transitionChar - 'A';
            //sets the arc connecting the new child
            transitionArcs |= 1 << positions;
            if (child == null) {
                children[transitionChar - 'A'] = new GADDAGNode();
            }
            else {
                children[transitionChar - 'A'] = child;
            }
            return children[transitionChar - 'A'];
        }
        else {
            return currentArcEndpoint;
        }
    }

    //sets the arc that completes a word
    public void setTerminalArcs(char terminalArc) {
        // get number of positions needed to shift 1 to make bitFlag
        int positions = terminalArc - 'A';
        terminalArcs |= 1 << positions;
    }

    public GADDAGNode getChildNode(char transitionChar) {
        // get number of positions needed to shift 1 to make bitFlag
        int positions = transitionChar - 'A';
        if(((1<<positions) & transitionArcs)!=0) {
            //childArc - 'A' will give us the index
            return children[transitionChar -'A'];
        }
        return null;
    }

    public GADDAGNode[] getChildren() {
        return children;
    }

    public int getTransitionArcs() {
        return transitionArcs;
    }

    public int getTerminalArcs() {
        return terminalArcs;
    }

    public int getId() {
        return id;
    }
}
