(ns frontendfi.core-test
  (:require [cljs.test :refer-macros [is are deftest testing use-fixtures]]
            [frontendfi.core :as rc]))

(deftest test-home
  (is (= true true)))

