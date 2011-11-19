// $ANTLR 3.4 C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g 2011-11-19 13:11:46

package org.eclipse.require.core.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class RequireConfigLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int Digit=4;
    public static final int Identifier=5;
    public static final int Letter=6;
    public static final int NewLine=7;
    public static final int SingleLineComment=8;
    public static final int StringLiteral=9;
    public static final int Whitespace=10;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public RequireConfigLexer() {} 
    public RequireConfigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RequireConfigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:11:7: ( ',' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:11:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:12:7: ( 'component' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:12:9: 'component'
            {
            match("component"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:13:7: ( 'plugins' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:13:9: 'plugins'
            {
            match("plugins"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:14:7: ( '{' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:15:7: ( '}' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:15:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:83:3: ( '\"' (~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:84:3: '\"' (~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 

            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:85:3: (~ ( '\"' | '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:96:3: ( Letter ( Letter | Digit )* )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:97:3: Letter ( Letter | Digit )*
            {
            mLetter(); 


            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:98:3: ( Letter | Digit )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:107:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:114:3: ( '0' .. '9' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "SingleLineComment"
    public final void mSingleLineComment() throws RecognitionException {
        try {
            int _type = SingleLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:118:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )? )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:119:3: '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )?
            {
            match("//"); 



            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:120:3: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:126:3: ( '\\n' | '\\r' ( '\\n' )? )?
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\n') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\r') ) {
                alt5=2;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:127:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:128:7: '\\r' ( '\\n' )?
                    {
                    match('\r'); 

                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:128:12: ( '\\n' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\n') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:128:13: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }



                _channel = HIDDEN;
               

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SingleLineComment"

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            int _type = NewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:137:3: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:138:3: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:138:3: ( '\\r' '\\n' | '\\r' | '\\n' )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
            }
            else if ( (LA6_0=='\n') ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:139:5: '\\r' '\\n'
                    {
                    match('\r'); 

                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:140:7: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:141:7: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }



                _channel = HIDDEN;
               

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NewLine"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:150:3: ( ( ' ' | '\\t' | '\\f' )+ )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:151:3: ( ' ' | '\\t' | '\\f' )+
            {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:151:3: ( ' ' | '\\t' | '\\f' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0=='\f'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);



                _channel = HIDDEN;
               

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Whitespace"

    public void mTokens() throws RecognitionException {
        // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | StringLiteral | Identifier | SingleLineComment | NewLine | Whitespace )
        int alt8=10;
        switch ( input.LA(1) ) {
        case ',':
            {
            alt8=1;
            }
            break;
        case 'c':
            {
            int LA8_2 = input.LA(2);

            if ( (LA8_2=='o') ) {
                int LA8_11 = input.LA(3);

                if ( (LA8_11=='m') ) {
                    int LA8_13 = input.LA(4);

                    if ( (LA8_13=='p') ) {
                        int LA8_15 = input.LA(5);

                        if ( (LA8_15=='o') ) {
                            int LA8_17 = input.LA(6);

                            if ( (LA8_17=='n') ) {
                                int LA8_19 = input.LA(7);

                                if ( (LA8_19=='e') ) {
                                    int LA8_21 = input.LA(8);

                                    if ( (LA8_21=='n') ) {
                                        int LA8_23 = input.LA(9);

                                        if ( (LA8_23=='t') ) {
                                            int LA8_25 = input.LA(10);

                                            if ( ((LA8_25 >= '0' && LA8_25 <= '9')||(LA8_25 >= 'A' && LA8_25 <= 'Z')||(LA8_25 >= 'a' && LA8_25 <= 'z')) ) {
                                                alt8=7;
                                            }
                                            else {
                                                alt8=2;
                                            }
                                        }
                                        else {
                                            alt8=7;
                                        }
                                    }
                                    else {
                                        alt8=7;
                                    }
                                }
                                else {
                                    alt8=7;
                                }
                            }
                            else {
                                alt8=7;
                            }
                        }
                        else {
                            alt8=7;
                        }
                    }
                    else {
                        alt8=7;
                    }
                }
                else {
                    alt8=7;
                }
            }
            else {
                alt8=7;
            }
            }
            break;
        case 'p':
            {
            int LA8_3 = input.LA(2);

            if ( (LA8_3=='l') ) {
                int LA8_12 = input.LA(3);

                if ( (LA8_12=='u') ) {
                    int LA8_14 = input.LA(4);

                    if ( (LA8_14=='g') ) {
                        int LA8_16 = input.LA(5);

                        if ( (LA8_16=='i') ) {
                            int LA8_18 = input.LA(6);

                            if ( (LA8_18=='n') ) {
                                int LA8_20 = input.LA(7);

                                if ( (LA8_20=='s') ) {
                                    int LA8_22 = input.LA(8);

                                    if ( ((LA8_22 >= '0' && LA8_22 <= '9')||(LA8_22 >= 'A' && LA8_22 <= 'Z')||(LA8_22 >= 'a' && LA8_22 <= 'z')) ) {
                                        alt8=7;
                                    }
                                    else {
                                        alt8=3;
                                    }
                                }
                                else {
                                    alt8=7;
                                }
                            }
                            else {
                                alt8=7;
                            }
                        }
                        else {
                            alt8=7;
                        }
                    }
                    else {
                        alt8=7;
                    }
                }
                else {
                    alt8=7;
                }
            }
            else {
                alt8=7;
            }
            }
            break;
        case '{':
            {
            alt8=4;
            }
            break;
        case '}':
            {
            alt8=5;
            }
            break;
        case '\"':
            {
            alt8=6;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt8=7;
            }
            break;
        case '/':
            {
            alt8=8;
            }
            break;
        case '\n':
        case '\r':
            {
            alt8=9;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt8=10;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:40: StringLiteral
                {
                mStringLiteral(); 


                }
                break;
            case 7 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:54: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 8 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:65: SingleLineComment
                {
                mSingleLineComment(); 


                }
                break;
            case 9 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:83: NewLine
                {
                mNewLine(); 


                }
                break;
            case 10 :
                // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:1:91: Whitespace
                {
                mWhitespace(); 


                }
                break;

        }

    }


 

}