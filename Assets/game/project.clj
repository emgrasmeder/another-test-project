(defproject clojurescript_app "0.1.0-SNAPSHOT"
  :description "ClojureScript App"
  :url "http://example.com/FIXME"
  :license
  {
   :name "Eclipse Public License"
   :url "http://www.eclipse.org/legal/epl-v10.html"
   }
  :dependencies
  [
   [org.clojure/clojure "1.5.1"]
   [org.clojure/clojurescript "0.0-2014"]]
  :plugins
  [
   [lein-cljsbuild "1.0.2"]]
  :cljsbuild
  {
   :builds [
            {
      :source-paths ["src/cljs"]
             :compiler
             {
              :output-to "resources/main.js"
              :optimization :whitespace}
             }
            ]
   }
  )
