package oop.examPreparation.august_14th_2022.football.core;

import oop.examPreparation.august_14th_2022.football.entities.field.ArtificialTurf;
import oop.examPreparation.august_14th_2022.football.entities.field.BaseField;
import oop.examPreparation.august_14th_2022.football.entities.field.NaturalGrass;
import oop.examPreparation.august_14th_2022.football.entities.player.Men;
import oop.examPreparation.august_14th_2022.football.entities.player.Player;
import oop.examPreparation.august_14th_2022.football.entities.player.Women;
import oop.examPreparation.august_14th_2022.football.entities.supplement.Liquid;
import oop.examPreparation.august_14th_2022.football.entities.supplement.Powdered;
import oop.examPreparation.august_14th_2022.football.entities.supplement.Supplement;
import oop.examPreparation.august_14th_2022.football.repositories.SupplementRepository;
import oop.examPreparation.august_14th_2022.football.repositories.SupplementRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;

import static oop.examPreparation.august_14th_2022.football.common.ConstantMessages.*;
import static oop.examPreparation.august_14th_2022.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Map<String, BaseField> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        BaseField field;

        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        this.fields.put(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;

        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        this.supplementRepository.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement byType = supplementRepository.findByType(supplementType);

        if (byType == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        BaseField field = fields.get(fieldName);

        field.addSupplement(byType);
        supplementRepository.remove(byType);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);

                if (!fields.get(fieldName).getClass().getSimpleName().equals("NaturalGrass")) {
                    return String.format(FIELD_NOT_SUITABLE);
                }
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);

                if (!fields.get(fieldName).getClass().getSimpleName().equals("ArtificialTurf")) {
                    return String.format(FIELD_NOT_SUITABLE);
                }
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }


        fields.get(fieldName).addPlayer(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        BaseField field = fields.get(fieldName);
        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        BaseField field = fields.get(fieldName);

        int totalStrength = field.getPlayers()
                .stream()
                .mapToInt(Player::getStrength)
                .sum();

        return String.format(STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, BaseField> field : fields.entrySet()) {
            sb.append(field.getValue().getInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
