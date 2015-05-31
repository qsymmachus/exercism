(ns nucleotide-count)

(declare nucleotide-counts, count, nucleotide?)

(defn nucleotide-counts
  "Given a string of dna, returns a count of each type."
  [dna]
  (merge {\A 0, \T 0, \C 0, \G 0} (frequencies (seq dna))))

(defn count
  "Given a string of dna and a nucleotide 'nuc', returns a count of 'nuc'."
  [nuc dna]
  (assert (nucleotide? nuc) "invalid nucleotide")
  (get (nucleotide-counts dna) nuc))

(defn nucleotide?
  "Checks whether a character is a valid nucleotide."
  [nuc]
  (some #(= nuc %) [\A, \T, \C, \G]))