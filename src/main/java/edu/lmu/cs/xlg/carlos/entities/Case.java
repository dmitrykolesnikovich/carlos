package edu.lmu.cs.xlg.carlos.entities;

/**
 * A condition/block pair (if-statements are made up of a bunch of these).
 */
public class Case extends Entity {

    private Expression condition;
    private Block body;

    public Case(Expression condition, Block body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void analyze(AnalysisContext context) {
        condition.analyze(context);
        if (condition.type != Type.BOOLEAN) {
            context.getLog().error("if_condition_not_boolean");
        }
        body.analyze(context);
    }
}
