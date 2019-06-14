package graphql.validation.directives.standardrules;

public class DecimalMaxRule extends AbstractDecimalMinMaxRule {

    public DecimalMaxRule() {
        super("DecimalMax");
    }

    @Override
    public String getDirectiveDeclarationSDL() {
        return String.format("directive @DecimalMax(value : String!, inclusive : Boolean! = true, message : String = \"%s\") " +
                        "on ARGUMENT_DEFINITION | INPUT_FIELD_DEFINITION",
                "graphql.validation.DecimalMax.message");
    }

    @Override
    public String getDescription() {
        return "The element must be a number whose value must be less than or equal to the specified maximum.";
    }
    @Override
    protected boolean isOK(boolean inclusive, int comparisonResult) {
        return inclusive ? comparisonResult <= 0 : comparisonResult < 0;
    }
}
