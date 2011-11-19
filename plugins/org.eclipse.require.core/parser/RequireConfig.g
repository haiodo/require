grammar RequireConfig;

options {
  language = Java;
//  output   = None;
}

@header {
package org.eclipse.require.core.parser;
  import org.eclipse.require.core.configuration.*;
}

@lexer::header {
package org.eclipse.require.core.parser;
}

configuration returns [Configuration config = ConfigurationFactory.eINSTANCE.createConfiguration()]
  :
  (c=component 
               {
                config.getComponents().add(c);
               })*
  ;

component returns [Component component = ConfigurationFactory.eINSTANCE.createComponent()]
  :
  'component'
  (
    id=Identifier 
                  {
                   component.setName(id.getText());
                  }
    | id2=StringLiteral 
                        {
                         String idval = id2.getText();
                         component.setName(idval.substring(1, idval.length() - 1));
                        }
  )
  '{'
  (
    pl=plugins 
               {
                component.getPlugins().addAll(pl);
               }
    | cl=component 
                   {
                    component.getComponents().add(cl);
                   }
  )*
  '}'
  ;

plugins returns [List<PluginRequire> plugins =  new ArrayList<PluginRequire>()]
  :
  'plugins'
  (
    pl=plugin_require 
                      {
                       plugins.add(pl);
                      }
    | '{' (p2=plugin_require 
                             {
                              plugins.add(p2);
                             }
      ',')* p3=plugin_require 
                              {
                               plugins.add(p3);
                              }
    '}'
  )
  ;

plugin_require returns [PluginRequire req = ConfigurationFactory.eINSTANCE.createPluginRequire()]
  :
  val=StringLiteral 
                    {
                     String v = val.getText();
                     req.setPattern(v.substring(1, v.length() - 1));
                    }
  ;

StringLiteral
  :
  '"'
  (
    ~(
      '"'
      | '\n'
      | '\r'
     )
  )*
  '"'
  ;

Identifier
  :
  Letter
  (
    Letter
    | Digit
  )*
  ;

fragment
Letter
  :
  'a'..'z'
  | 'A'..'Z'
  ;

fragment
Digit
  :
  '0'..'9'
  ;

SingleLineComment
  :
  '//'
  (
    ~(
      '\n'
      | '\r'
     )
  )*
  (
    '\n'
    | '\r' ('\n')?
  )?
  
   {
    $channel = HIDDEN;
   }
  ;

NewLine
  :
  (
    '\r' '\n'
    | '\r'
    | '\n'
  )
  
   {
    $channel = HIDDEN;
   }
  ;

Whitespace
  :
  (
    ' '
    | '\t'
    | '\f'
  )+
  
   {
    $channel = HIDDEN;
   }
  ;
