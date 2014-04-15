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

(ns jansi-clj-test.main
  (:require [jansi-clj.core :as jansi])
  (:gen-class))

; Toggle this to demonstrate both behaviours (i.e. initialised vs not-initialised)
(def ^:private install-jansi? true)

(defn -main
  [& args]
  (if install-jansi? (jansi/install!))
  (println (jansi/green "This text should be green."))
  (println (jansi/red "This text should be red."))
  (println (str "This text shouldn't appear at all."
                (jansi/cursor-left (.length "This text shouldn't appear at all."))
                (jansi/erase-line)
                "This text should be unformatted.")))
