;
; Copyright © 2013,2014 Peter Monks (pmonks@gmail.com)
;
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
; 
;     http://www.apache.org/licenses/LICENSE-2.0
; 
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
;

(defproject jansi-clj-test "0.1.0-SNAPSHOT"
  :description      "Test of jansi-clj library."
  :license          {:name "Apache License, Version 2.0"
                     :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :min-lein-version "2.0.0"
  :javac-target     "1.7"
  :dependencies [
                  [org.clojure/clojure                "1.6.0"]
                  [jansi-clj                          "0.1.0"]
                ]
  :profiles {:dev {:dependencies [
                                   [midje          "1.6.3"]
                                   [clj-ns-browser "1.3.1"]
                                 ]
                   :plugins      [[lein-midje "3.1.1"]]}   ; Don't remove this or travis-ci will assplode!
             :uberjar {:aot :all}}
  :uberjar-merge-with {#"META-INF/services/.*" [slurp str spit]}   ; Awaiting Leiningen 2.3.5 - see https://github.com/technomancy/leiningen/issues/1455
  :main jansi-clj-test.main
  :jvm-opts ["-server"]
  :bin {:name "jct"})
