(ns rna-transcription)

(declare dna? convert-nucleotide)

(defn to-rna
  "Converts a DNA strand into an RNA strand, both represented as strings."
  [dna]
  (apply str (map convert-nucleotide dna)))

(defn convert-nucleotide
  "Converts a DNA nucleotide into its RNA equivalent."
  [nuc]
  (let [nuc-mapping {\G \C, \C \G, \T \A, \A \U }]
    (assert (dna? nuc))
    (get nuc-mapping nuc)))

(defn dna?
  "Checks whether a character is a valid DNA nucleotide."
  [nuc]
  (some #(= nuc %) [\G \C \T \A]))
