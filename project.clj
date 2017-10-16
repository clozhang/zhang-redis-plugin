(defproject clozhang/zhang-redis-plugin "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/clozhang/zhang-redis-plugin"
  :license {
    :name "Apache License, Version 2.0"
    :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :exclusions [org.clojure/clojure]
  :dependencies [
    [clojusc/trifl "0.2.0"]
    [clojusc/twig "0.3.2"]
    [com.taoensso/carmine "2.16.0"]
    [org.clojure/clojure "1.8.0"]]
  :profiles {
    :dev {
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"]]
      :source-paths ["dev-resources/src"]
      :repl-options {:init-ns zhang.plugins.redis.dev}}
    :test {
      :test-selectors {
        :default :unit
        :unit :unit
        :system :system
        :integration :integration}
      :plugins [
        [lein-ancient "0.6.12"]
        [jonase/eastwood "0.2.5"]
        [lein-bikeshed "0.5.0"]
        [lein-kibit "0.1.5"]
        [venantius/yagni "0.1.4"]]}
    :ubercompile {:aot :all}}
  :aliases {
    "check-deps"
      ["with-profile" "+test" "ancient" "check" ":all"]
    "ubercompile"
      ["with-profile" "+ubercompile" "compile"]
    "build"
      ["do" ["check"]
            ["check-deps"]
            ["ubercompile"]
            ["clean"]
            ["test"]
            ["uberjar"]]})
