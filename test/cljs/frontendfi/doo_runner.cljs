(ns frontendfi.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [frontendfi.core-test]))

(doo-tests 'frontendfi.core-test)

