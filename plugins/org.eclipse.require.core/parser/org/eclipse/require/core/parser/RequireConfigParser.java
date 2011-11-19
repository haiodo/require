// $ANTLR 3.4 C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g 2011-11-19 13:11:46

package org.eclipse.require.core.parser;
  import org.eclipse.require.core.configuration.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class RequireConfigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Digit", "Identifier", "Letter", "NewLine", "SingleLineComment", "StringLiteral", "Whitespace", "','", "'component'", "'plugins'", "'{'", "'}'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public RequireConfigParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public RequireConfigParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return RequireConfigParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g"; }



    // $ANTLR start "configuration"
    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:17:1: configuration returns [Configuration config = ConfigurationFactory.eINSTANCE.createConfiguration()] : (c= component )* ;
    public final Configuration configuration() throws RecognitionException {
        Configuration config =  ConfigurationFactory.eINSTANCE.createConfiguration();


        Component c =null;


        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:18:3: ( (c= component )* )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:19:3: (c= component )*
            {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:19:3: (c= component )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:19:4: c= component
            	    {
            	    pushFollow(FOLLOW_component_in_configuration51);
            	    c=component();

            	    state._fsp--;



            	                    config.getComponents().add(c);
            	                   

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return config;
    }
    // $ANTLR end "configuration"



    // $ANTLR start "component"
    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:25:1: component returns [Component component = ConfigurationFactory.eINSTANCE.createComponent()] : 'component' (id= Identifier |id2= StringLiteral ) '{' (pl= plugins |cl= component )* '}' ;
    public final Component component() throws RecognitionException {
        Component component =  ConfigurationFactory.eINSTANCE.createComponent();


        Token id=null;
        Token id2=null;
        List<PluginRequire> pl =null;

        Component cl =null;


        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:26:3: ( 'component' (id= Identifier |id2= StringLiteral ) '{' (pl= plugins |cl= component )* '}' )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:27:3: 'component' (id= Identifier |id2= StringLiteral ) '{' (pl= plugins |cl= component )* '}'
            {
            match(input,12,FOLLOW_12_in_component90); 

            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:28:3: (id= Identifier |id2= StringLiteral )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Identifier) ) {
                alt2=1;
            }
            else if ( (LA2_0==StringLiteral) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:29:5: id= Identifier
                    {
                    id=(Token)match(input,Identifier,FOLLOW_Identifier_in_component102); 


                                       component.setName(id.getText());
                                      

                    }
                    break;
                case 2 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:33:7: id2= StringLiteral
                    {
                    id2=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_component133); 


                                             String idval = id2.getText();
                                             component.setName(idval.substring(1, idval.length() - 1));
                                            

                    }
                    break;

            }


            match(input,14,FOLLOW_14_in_component168); 

            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:40:3: (pl= plugins |cl= component )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }
                else if ( (LA3_0==12) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:41:5: pl= plugins
            	    {
            	    pushFollow(FOLLOW_plugins_in_component180);
            	    pl=plugins();

            	    state._fsp--;



            	                    component.getPlugins().addAll(pl);
            	                   

            	    }
            	    break;
            	case 2 :
            	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:45:7: cl= component
            	    {
            	    pushFollow(FOLLOW_component_in_component208);
            	    cl=component();

            	    state._fsp--;



            	                        component.getComponents().add(cl);
            	                       

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,15,FOLLOW_15_in_component239); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return component;
    }
    // $ANTLR end "component"



    // $ANTLR start "plugins"
    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:53:1: plugins returns [List<PluginRequire> plugins = new ArrayList<PluginRequire>()] : 'plugins' (pl= plugin_require | '{' (p2= plugin_require ',' )* p3= plugin_require '}' ) ;
    public final List<PluginRequire> plugins() throws RecognitionException {
        List<PluginRequire> plugins =   new ArrayList<PluginRequire>();


        PluginRequire pl =null;

        PluginRequire p2 =null;

        PluginRequire p3 =null;


        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:54:3: ( 'plugins' (pl= plugin_require | '{' (p2= plugin_require ',' )* p3= plugin_require '}' ) )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:55:3: 'plugins' (pl= plugin_require | '{' (p2= plugin_require ',' )* p3= plugin_require '}' )
            {
            match(input,13,FOLLOW_13_in_plugins258); 

            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:56:3: (pl= plugin_require | '{' (p2= plugin_require ',' )* p3= plugin_require '}' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==StringLiteral) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:57:5: pl= plugin_require
                    {
                    pushFollow(FOLLOW_plugin_require_in_plugins270);
                    pl=plugin_require();

                    state._fsp--;



                                           plugins.add(pl);
                                          

                    }
                    break;
                case 2 :
                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:61:7: '{' (p2= plugin_require ',' )* p3= plugin_require '}'
                    {
                    match(input,14,FOLLOW_14_in_plugins303); 

                    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:61:11: (p2= plugin_require ',' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==StringLiteral) ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1==11) ) {
                                alt4=1;
                            }


                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:61:12: p2= plugin_require ','
                    	    {
                    	    pushFollow(FOLLOW_plugin_require_in_plugins308);
                    	    p2=plugin_require();

                    	    state._fsp--;



                    	                                  plugins.add(p2);
                    	                                 

                    	    match(input,11,FOLLOW_11_in_plugins348); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    pushFollow(FOLLOW_plugin_require_in_plugins354);
                    p3=plugin_require();

                    state._fsp--;



                                                   plugins.add(p3);
                                                  

                    match(input,15,FOLLOW_15_in_plugins393); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return plugins;
    }
    // $ANTLR end "plugins"



    // $ANTLR start "plugin_require"
    // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:73:1: plugin_require returns [PluginRequire req = ConfigurationFactory.eINSTANCE.createPluginRequire()] : val= StringLiteral ;
    public final PluginRequire plugin_require() throws RecognitionException {
        PluginRequire req =  ConfigurationFactory.eINSTANCE.createPluginRequire();


        Token val=null;

        try {
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:74:3: (val= StringLiteral )
            // C:\\Develop\\git\\require\\plugins\\org.eclipse.require.core\\parser\\RequireConfig.g:75:3: val= StringLiteral
            {
            val=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_plugin_require418); 


                                 String v = val.getText();
                                 req.setPattern(v.substring(1, v.length() - 1));
                                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return req;
    }
    // $ANTLR end "plugin_require"

    // Delegated rules


 

    public static final BitSet FOLLOW_component_in_configuration51 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_component90 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_Identifier_in_component102 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_StringLiteral_in_component133 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_component168 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_plugins_in_component180 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_component_in_component208 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_15_in_component239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_plugins258 = new BitSet(new long[]{0x0000000000004200L});
    public static final BitSet FOLLOW_plugin_require_in_plugins270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_plugins303 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_plugin_require_in_plugins308 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_plugins348 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_plugin_require_in_plugins354 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_plugins393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_plugin_require418 = new BitSet(new long[]{0x0000000000000002L});

}