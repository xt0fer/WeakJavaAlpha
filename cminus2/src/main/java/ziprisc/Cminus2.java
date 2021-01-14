package ziprisc;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ziprisc.parser.Cminus2Lexer;
import ziprisc.parser.Cminus2Listener;
import ziprisc.parser.Cminus2Parser;

/**
 * Hello world!
 *
 */
public class Cminus2 {
    private static final String PROGRAM = "int main() { int i; \ni = 0;\n return i;\n}";

    public static void main(String[] args) {
        String cminusContent = Cminus2.PROGRAM;
        Cminus2Lexer lexer = new Cminus2Lexer(CharStreams.fromString(cminusContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Cminus2Parser parser = new Cminus2Parser(tokens);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        Cminus2Listener listener = new Cm2Listener();
        walker.walk(listener, tree);
        System.out.println(tree.toStringTree(parser)); 

    }
}
