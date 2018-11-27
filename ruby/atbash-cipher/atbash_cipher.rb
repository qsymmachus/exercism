module Atbash
  @@forwards = "abcdefghijklmnopqrstuvwxyz".split("")
  @@backwards = "zyxwvutsrqponmlkjihgfedcba".split("")
  @@encode_mapping = @@forwards.zip(@@backwards).to_h
  @@decode_mapping = @@backwards.zip(@@forwards).to_h  

  class << self
    def encode(plaintext)
      plaintext
        .gsub(/\W/, "")
        .split("")
        .map.with_index(1) do |char, i|
          if i % 5 == 0
            encode_character(char) + " "
          else
            encode_character(char)
          end
        end
        .join
        .strip
    end

    def decode(ciphertext)
      ciphertext
        .gsub(/\W/, "")
        .split("")
        .map.with_index(1) do |char, i|
          if i % 5 == 0
            decode_character(char) + " "
          else
            decode_character(char)
          end
        end
        .join
        .strip
    end

    private

    def encode_character(character)
      result = @@encode_mapping[character.downcase]

      result.nil? ? character : result
    end

    def decode_character(character)
      result = @@decode_mapping[character.downcase]

      result.nil? ? character : result
    end
  end
end
